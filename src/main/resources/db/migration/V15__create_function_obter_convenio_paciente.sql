CREATE OR REPLACE FUNCTION fn_obter_convenio_paciente(
    p_paciente_id INT
)
RETURNS TEXT
LANGUAGE plpgsql
AS $$
DECLARE
v_convenio TEXT;
BEGIN
    IF p_paciente_id IS NULL THEN
        RAISE EXCEPTION 'ID do paciente não informado';
END IF;

SELECT c.nome
INTO v_convenio
FROM convenio c
         JOIN paciente p ON p.convenio_id = c.id
WHERE p.id = p_paciente_id;

RETURN v_convenio;
END;
$$;
