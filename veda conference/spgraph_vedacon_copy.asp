	<!--#include file="../inc/bsHtmlLayoutTop.inc"-->
	<!--#include file="../inc/bsNavbarTop.inc"-->
	<!--#include file="../inc/fnProperCase.inc"-->
	<!--#include file="../global_include.inc"-->
	<%Catcd=Request.Cookies("Catcd")%>
	<div class="container-fluid">
	<!--#include file="../inc/sidebarDashboard.inc"-->
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h1 class="page-header">Veda Conference</h1>
		</div>
		
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">  
			<% '#############################################
			%>	
	<!--#include file="../_fpclass/fpdblib.inc"-->
			
			<%
				dist=Request.Cookies("Distcd")
				
				if  (Catcd=CATCD_NATIONAL) Then 
					'fp_sQry="SELECT Sex,COUNT(*) as tot FROM PER_DETAILS,samitis where samitis.samiti =PER_DETAILS.city  and mstatus='APPROVED' and floor(datediff (now(), dob)/365) > 18 and floor(datediff (now(), dob)/365) < 60 and stu_balvikas=1 GROUP BY Sex  "
					fp_sQry="SELECT Gender as Sex,COUNT(*) as tot FROM vedaconference,samitis where samitis.samiti =vedaconference.city GROUP BY Sex"
				else
					if (Catcd=CATCD_DISTRICT) Then 
						'fp_sQry="SELECT Sex,COUNT(*) as tot FROM PER_DETAILS,samitis where samitis.samiti =PER_DETAILS.city and samitis.dist_cd='" & dist & "' and photo is not null and mstatus='APPROVED' and floor(datediff (now(), dob)/365) > 18 and floor(datediff (now(), dob)/365) < 60 and stu_balvikas=1  GROUP BY Sex "
                        fp_sQry="SELECT Gender as Sex,COUNT(*) as tot FROM vedaconference,samitis where samitis.samiti =vedaconference.City and samitis.dist_cd='" & dist & "' GROUP BY Sex "
						else 
						'fp_sQry="SELECT Sex,COUNT(*) as tot FROM PER_DETAILS,M_param where m_param.Cat_typ='dist' and m_param.Cat_cd=PER_DETAILS.Dist_cd  and "& dist &" and mstatus='APPROVED' and floor(datediff (now(), dob)/365) > 18 and floor(datediff (now(), dob)/365) < 60 and stu_balvikas=1  GROUP BY Sex "
					     fp_sQry="SELECT Gender as Sex,COUNT(*) as tot FROM PER_DETAILS,M_param,vedaconference where m_param.Cat_typ='dist' and m_param.Cat_cd=PER_DETAILS.Dist_cd  and PER_DETAILS.Dist_cd='"& dist &"' and PER_DETAILS.city=vedaconference.City GROUP BY Sex"
					end if
				end if
				fp_sDefault=""
				fp_sNoRecords=""
				fp_sDataConn="ssssoseva"
				'fp_iMaxRecords=256
				fp_iCommandType=1
				fp_iPageSize=0
				fp_fTableFormat=True
				fp_fMenuFormat=False
				fp_sMenuChoice=""
				fp_sMenuValue=""
				fp_iDisplayCols=4
				fp_fCustomQuery=True
				BOTID=0
				fp_iRegion=BOTID
			%>
			<div class="chartWithOverlay">
				<div id="chart"></div>
				<div class="overlay">
					<div><strong>Statistics</strong></div>
	<!--#include file="../_fpclass/fpdbrgn1.inc"-->
						<% if  FP_FieldVal(fp_rs,"Sex")=1 Then %>
							<div>Gents: <%=FP_FieldVal(fp_rs,"tot")%></div>
						<% else %>
							<div>Mahilas: <%=FP_FieldVal(fp_rs,"tot")%></div>
						<% end if %>    
	<!--#include file="../_fpclass/fpdbrgn2.inc"-->				
				<%
					tot_SSdist=0
					tot_samiti=0
					tot_BM =0
					tot_state=0
					if  (Catcd=CATCD_NATIONAL) Then 
						fp_sQry="select count(*) t_ssdist from m_param where cat_typ='dist'  "
					else
						if (Catcd=CATCD_DISTRICT) Then 
							fp_sQry="select count(*) t_ssdist from m_param where cat_typ='dist' and  m_param.cat_cd='"& dist &"'  "
						else 
							fp_sQry="select count(*) t_ssdist from m_param,statemaster where cat_typ='dist' and statemaster.state=left(m_param.cat_cd,2) and "& dist &"  "
						end if
					end if
				%>
	<!--#include file="../_fpclass/fpdbrgn1.inc"-->
				<% tot_SSdist=FP_FieldVal(fp_rs,"t_ssdist")%> 
	<!--#include file="../_fpclass/fpdbrgn2.inc"-->
				<%
					if  (Catcd=CATCD_NATIONAL) Then 
						fp_sQry="select count(*) t_st from statemaster "
					else
						if (Catcd=CATCD_DISTRICT) Then 
							fp_sQry="select count(*) as t_st from samitis  where dist_cd='"& dist &"'"
						else 
							fp_sQry="select count(*) t_st from statemaster  where  "& dist &" "
						end if
					end if
				%>
	<!--#include file="../_fpclass/fpdbrgn1.inc"-->
				<% tot_state=FP_FieldVal(fp_rs,"t_st")%>  
	<!--#include file="../_fpclass/fpdbrgn2.inc"-->
				<%
					if  (Catcd=CATCD_NATIONAL) Then 
						fp_sQry="select count(*) as tot_no,BM_FLAG  from samitis group by BM_FLAG "
					else

						if (Catcd=CATCD_DISTRICT) Then 
							fp_sQry="select count(*) as tot_no,BM_FLAG  from samitis  where dist_cd='"& dist &"' group by BM_FLAG "
						else 
							fp_sQry="select count(*) as tot_no,BM_FLAG  from samitis,statemaster  where statemaster.state=left(samitis.Dist_cd,2) and "& dist &" group by BM_FLAG "
						end if
					end if
				%>
	<!--#include file="../_fpclass/fpdbrgn1.inc"-->
				<% 
					if FP_FieldVal(fp_rs,"BM_FLAG")="BM" then
						tot_BM =FP_FieldVal(fp_rs,"tot_no") 
					else
						tot_samiti=FP_FieldVal(fp_rs,"tot_no")
					end if    	
				%> 
	<!--#include file="../_fpclass/fpdbrgn2.inc"-->				
					<% if(Catcd=CATCD_DISTRICT) then %>
						<div></div>
					<% else %>
						<div>States: <%=tot_state%></div>
					<% end if %>
					<div>Districts: <%=tot_SSdist%></div>
					<div>Samithis: <%=tot_samiti%></div>
					<div>Bh_Mandlies: <%=tot_BM%></div>
					<p></p>
				<div><strong>Approval Pending</strong></div>
				<%
					if  (Catcd=CATCD_NATIONAL) Then 
						'fp_sQry="SELECT Sex,COUNT(*) as tot FROM PER_DETAILS,samitis where samitis.samiti =PER_DETAILS.city  and mstatus='PENDING_APPROVAL' and floor(datediff (now(), dob)/365) > 18 and floor(datediff (now(), dob)/365) < 60 and stu_balvikas=1 GROUP BY Sex "
						fp_sQry="SELECT Gender as Sex,COUNT(*) as tot FROM vedaconference,samitis where samitis.samiti =vedaconference.city GROUP BY Sex"
					else
						if (Catcd=CATCD_DISTRICT) Then 
							'fp_sQry="SELECT Sex,COUNT(*) as tot FROM PER_DETAILS,samitis where samitis.samiti =PER_DETAILS.city and samitis.dist_cd='" & dist & "'  and photo is not null and mstatus<>'APPROVED' and floor(datediff (now(), dob)/365) > 18 and floor(datediff (now(), dob)/365) < 60 and stu_balvikas=1  GROUP BY Sex "
							'fp_sQry=
						else 
							fp_sQry="SELECT Sex,COUNT(*) as tot FROM PER_DETAILS,M_param where m_param.Cat_typ='dist' and m_param.Cat_cd=PER_DETAILS.Dist_cd and "& dist &"  and mstatus<>'APPROVED' and floor(datediff (now(), dob)/365) > 18 and floor(datediff (now(), dob)/365) < 60 and stu_balvikas=1 GROUP BY Sex "
						end if
					end if
				%>
	<!--#include file="../_fpclass/fpdbrgn1.inc"-->
				<% if  FP_FieldVal(fp_rs,"Sex")=1 Then %>
					<div>Gents: <%=FP_FieldVal(fp_rs,"tot")%></div>
				<% else %>
					<div>Mahilas: <%=FP_FieldVal(fp_rs,"tot")%></div>
				<% end if %>    
	<!--#include file="../_fpclass/fpdbrgn2.inc"-->
				
				<%
					'fp_sQry="SELECT m_param.cat_name as city,Sex,COUNT(*) as tot_d FROM PER_DETAILS,M_param where m_param.Cat_typ='dist' and m_param.Cat_cd=PER_DETAILS.Dist_cd and "& dist &" and mstatus='APPROVED' and floor(datediff (now(), dob)/365) > 18 and floor(datediff (now(), dob)/365) < 60 and stu_balvikas=1 GROUP BY cat_name,Sex"
					if  (Catcd=CATCD_NATIONAL) Then 						
						fp_sQry="SELECT state_name as City,COUNT(CASE WHEN sex = '1' THEN sno END) AS males, COUNT(CASE WHEN sex = '0' THEN sno END) AS females,COUNT(*) as tot_d FROM PER_DETAILS,samitis, statemaster where samitis.samiti =PER_DETAILS.city and statemaster.state= per_details.state  and mstatus='APPROVED' and floor(datediff (now(), dob)/365) > 18 and floor(datediff (now(), dob)/365) < 60 and stu_balvikas=1 GROUP BY state_name"
					else
						if (Catcd=CATCD_DISTRICT) Then 
							fp_sQry="SELECT samitis.samiti as city,COUNT(CASE WHEN sex = '1' THEN sno END) AS males, COUNT(CASE WHEN sex = '0' THEN sno END) AS females,COUNT(*) as tot_d FROM PER_DETAILS,samitis where samitis.samiti =PER_DETAILS.city and samitis.dist_cd='" & dist & "' and photo is not null and mstatus='APPROVED' and floor(datediff (now(), dob)/365) > 18 and floor(datediff (now(), dob)/365) < 60 and stu_balvikas=1  GROUP BY samitis.samiti"
						else 
							fp_sQry="SELECT m_param.cat_name AS city, COUNT(CASE WHEN sex = '1' THEN sno END) AS males, COUNT(CASE WHEN sex = '0' THEN sno END) AS females, COUNT(*) AS tot_d FROM PER_DETAILS,M_param where m_param.Cat_typ='dist' and m_param.Cat_cd=PER_DETAILS.Dist_cd and "& dist &" and mstatus='APPROVED' and floor(datediff (now(), dob)/365) > 18 and floor(datediff (now(), dob)/365) < 60 and stu_balvikas=1 GROUP BY cat_name"
						end if
					end if
				%>
				<script>
					var arr = [
						['City', 'Gents', 'Mahilas'],
	<!--#include file="../_fpclass/fpdbrgn1.inc"-->
						['<%=ProperCase(FP_FieldVal(fp_rs,"City"))%>',
						<%=FP_FieldVal(fp_rs,"males")%>,
						<%=FP_FieldVal(fp_rs,"females")%>],
	<!--#include file="../_fpclass/fpdbrgn2.inc"-->
					];
				</script>
				<script src="/bs/js/graph.js"></script>
				</div>
			</div>
		</div>
	</div>
</body>
</html>