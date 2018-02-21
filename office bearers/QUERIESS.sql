SELECT DISTINCT 
	PD1.Sno
	,PD1.FirstName
	,PD1.MiddleName
	,PD1.LastName
	,MP1.Cat_name
	,PD2.Sno
	,PD2.FirstName
	,PD2.MiddleName
	,PD2.LastName
	,MP2.Cat_name
	,PD1.*
FROM
	PER_DETAILS AS PD1
	,PER_DETAILS AS PD2
	,M_PARAM AS MP1
	,M_PARAM AS MP2
	,postdetails AS po1
	,postdetails AS po2
WHERE  MP1.Cat_name LIKE 'DIST. GENTS CO.(SPIRITUAL)' 
	AND MP1.Cat_cd=po1.post_held
	AND po1.slno_per_detail=PD1.Sno
	AND MP1.Cat_typ='post'
	AND (PD1.state LIKE 'TN%' ) 
	AND  PD1.City=PD2.City
	AND PD2.Sno=po2.slno_per_detail
	AND po2.post_held=MP2.Cat_cd
	AND MP2.Cat_typ='post'
	AND MP2.Cat_name LIKE 'STATE EDU. CONVENOR'

SELECT DISTINCT
	PD1.FirstName AS M_FirstName
	,PD1.MiddleName AS M_MiddleName
	,PD1.LastName AS M_LastName
	,PD1.*
	,PD2.FirstName AS SC_FirstName
	,PD2.MiddleName AS SC_MiddleName
	,PD2.LastName AS SC_LastName
	,MP1.Cat_name
	,MP2.Cat_name
FROM
	PER_DETAILS AS PD1
	,PER_DETAILS AS PD2
	,M_PARAM AS MP1
	,M_PARAM AS MP2
	,postdetails AS po1
	,postdetails AS po2
WHERE ( MP1.Cat_name LIKE 'DIST. GENTS CO.(SPIRITUAL)' )
	AND MP1.Cat_cd=po1.post_held
	AND po1.slno_per_detail=PD1.Sno
	AND MP1.Cat_typ='post'
	AND (PD1.State LIKE 'TN%')
	AND PD1.City=PD2.City
	AND PD2.Sno=po2.slno_per_detail
	AND MP2.Cat_typ='post'
SELECT 	`sl_no`, 
	`Dist_cd`, 
	`Samiti`, 
	`BM_FLAG`
	 
	FROM 
	samitis
	WHERE  SAMITIS.Samiti LIKE '%K.K`samitis`%'
	LIMIT 0, 1000;

	AND MP2.Cat_name LIKE '%CONVENOR%'
	AND po2.post_held=MP2.Cat_cd