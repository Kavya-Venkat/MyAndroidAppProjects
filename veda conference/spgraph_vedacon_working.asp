	<!--#include file="../inc/bsHtmlLayoutTop.inc"-->
	<!--#include file="../inc/bsNavbarTop.inc"-->
	<!--#include file="../inc/fnProperCase.inc"-->
	<!--#include file="../global_include.inc"-->
	<%Catcd=Request.Cookies("Catcd")%>
	<!--#include file="../inc/sidebarVedaConference.inc"-->
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h1 class="page-header">Veda Conference</h1>
		</div>
		
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">  
			<% '#############################################
			%>	
	<!--#include file="../_fpclass/fpdblib.inc"-->
			
			<%
				dist=Request.Cookies("Distcd")
				
				fp_sQry="SELECT Gender AS Sex,COUNT(*) AS tot FROM vedaconference GROUP BY Gender "
						
				
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
						<% if  FP_FieldVal(fp_rs,"Sex")="M" Then %>
							<div>Gents: <%=FP_FieldVal(fp_rs,"tot")%></div>
						<% else %>
							<div>Mahilas: <%=FP_FieldVal(fp_rs,"tot")%></div>
						<% end if %>  
						
						   

	<!--#include file="../_fpclass/fpdbrgn2.inc"-->				
					
					
	<!--#include file="../_fpclass/fpdbrgn1.inc"-->
			  
	<!--#include file="../_fpclass/fpdbrgn2.inc"-->
				
				<%
					
					fp_sQry="SELECT City, COUNT(CASE WHEN Gender = 'M' THEN Sainetid END) AS males, COUNT(CASE WHEN Gender = 'F' THEN Sainetid END) AS females,COUNT(*) AS tot_d FROM vedaconference GROUP BY City"	
					
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