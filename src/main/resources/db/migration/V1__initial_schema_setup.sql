-- Initial schema setup
-- This script contains the initial database schema setup including the context package

-- First let's check if package already exists to avoid errors
DECLARE
  v_count NUMBER;
BEGIN
  -- Check if the package already exists
  SELECT COUNT(*) INTO v_count 
  FROM all_objects 
  WHERE object_name = 'DATABSE_CONNECTION_CONTEXT'
  AND owner = 'WEBAPP'
  AND object_type = 'PACKAGE';
  
  -- Only create the package if it doesn't exist
  IF v_count = 0 THEN
    EXECUTE IMMEDIATE 'CREATE OR REPLACE PACKAGE webapp.DATABSE_CONNECTION_CONTEXT IS
      PROCEDURE set_connection_context (p_username IN VARCHAR2);
    END;';
  END IF;
END;
/

-- Create package body, replacing if exists
BEGIN
  EXECUTE IMMEDIATE 'CREATE OR REPLACE PACKAGE BODY webapp.DATABSE_CONNECTION_CONTEXT IS
    PROCEDURE set_connection_context (p_username IN VARCHAR2) IS
    BEGIN
      DBMS_SESSION.set_context(namespace => ''WEBAPP_CTX'', attribute => ''USERNAME'', value => p_username);
    END set_connection_context;
  END;';
END;
/

Check if context already exists before creating it
DECLARE
  v_count NUMBER;
BEGIN
  SELECT COUNT(*) INTO v_count 
  FROM dba_context 
  WHERE namespace = 'WEBAPP_CTX';
  
  IF v_count = 0 THEN
    -- Create the application context if it doesn't exist
    EXECUTE IMMEDIATE 'CREATE CONTEXT WEBAPP_CTX USING webapp.DATABSE_CONNECTION_CONTEXT';
  END IF;
END;
/

