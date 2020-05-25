CREATE OR REPLACE TRIGGER TRG_CUSTOMER
BEFORE INSERT OR UPDATE ON CUSTOMER
FOR EACH ROW
DECLARE
BEGIN

 	IF (:NEW.CREDITS < 0) THEN
		RAISE_APPLICATION_ERROR(-20999, 'The credits has to be greater or equal to 0');
	END IF;
	
	IF (:NEW.BIRTHDAY >= SYSDATE FROM DUAL) THEN
		RAISE_APPLICATION_ERROR(-20998, 'The birthday must be below ' || SYSDATE FROM DUAL);
	END IF;
	
	IF(UPDATING) THEN
		IF(:NEW.BIRTHDAY <> OLD:BIRTHDAY)
			RAISE_APPLICATION_ERROR(-20997, 'The birthday can not be updated');
	END IF;
	
	IF (:NEW.EMAIL NOT LIKE '^.+@.+') THEN
		RAISE_APPLICATION_ERROR(-20996, 'The email must contain an @-sign!');
	END IF;
	
	IF  NOT REGEXP_LIKE(:NEW.EMAIL, '^[A-Za-z][A-Za-z.0-9]+@[A-Za-z]+\.[A-Za-z]+$') THEN
		RAISE_APPLICATION_ERROR(-20995, 'This is not a valid email-address');
	END IF;	
	
END TRG_CUSTOMER;

