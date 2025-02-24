-- tables: lineitem

SELECT /*+SET_VAR(enable_pipeline_engine=true) */ sum(l_extendedprice * l_discount) AS revenue
FROM
  lineitem
WHERE
  l_shipdate >= DATEV2 '1994-01-01'
  AND l_shipdate < DATEV2 '1994-01-01' + INTERVAL '1' YEAR
AND l_discount BETWEEN 0.06 - 0.01 AND .06 + 0.01
AND l_quantity < 24

