	<!--#include file="../inc/bsHtmlLayoutTop.inc"-->
	<!--#include file="../inc/bsNavbarTop.inc"-->
	<!--#include file="../inc/sidebarMembers.inc"-->
	<!--#include file="../global_include.inc"-->
	<%Catcd=Request.Cookies("Catcd")%>
	<div class="container-fluid">		
        <div class="row">            
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <h1 class="page-header">Office Bearers</h1>
            </div>
        </div> 
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<form name="stock" method="post" action="officbearers.asp?members" id="officeBearersForm">
				<div class="form-inline">
					<label>Select: </label>
	<!--#include file="../_fpclass/fpdblib.inc"-->
					<%
						dist=Request.Cookies("Distcd")'Session("Dist_cd")
											
						if(Catcd =CATCD_DISTRICT or Catcd=CATCD_STATE)then
							fp_sQry="SELECT Cat_name as Samiti FROM M_PARAM WHERE Cat_typ ='post' AND ( Cat_cd LIKE 'S%' OR Cat_cd LIKE 'D%') "
						else
							fp_sQry="SELECT Cat_name as Samiti FROM M_PARAM WHERE Cat_typ ='post' AND ( Cat_cd LIKE 'S%' OR Cat_cd LIKE 'D%' OR Cat_cd LIKE 'A%') "
						end if
						fp_sDefault=""
						fp_sNoRecords="<tr><td colspan=6 align=left width=""100%"">No records returned.</td></tr>"
						fp_sDataConn="ssssoseva"
						'fp_iMaxRecords=256
						fp_iCommandType=1
						fp_fTableFormat=True
						fp_fMenuFormat=False
						fp_sMenuChoice=""
						fp_sMenuValue=""
						'fp_iDisplayCols=6
						fp_fCustomQuery=False
						BOTID=0
						fp_iRegion=BOTID
					%>
					<select name="sect" class="form-control" id="officeBearersOption">	
						<option value="">Select group...</option>
	<!--#include file="../_fpclass/fpdbrgn1.inc"-->
						<option <% if Request.Form("sect") = FP_FieldHTML(fp_rs,"Samiti") then %> selected = "selected" <% end if %> value="<%=FP_FieldHTML(fp_rs,"Samiti")%>"><%=FP_FieldHTML(fp_rs,"Samiti")%></option>
	<!--#include file="../_fpclass/fpdbrgn2.inc"-->
					</select>		
				</div>
			</form>
			<hr />
			<form name="form_list" target="_self" action="officbearers.asp" method="post" >
				<div id="officbearersDiv">
					<table class="table table-striped table-bordered" id="officbearers">
						<thead> 
							<th>Sainet ID</th>
							<th>Name</th>
							<th>Address</th>
							<th>Samithi</th>
							<th>Samithi Convenor</th>
							<th>Mobile Phone</th>											
							<th>Email</th>
							<th>Gender</th>							
							<th>Occupation</th>						
							<th>Reg Date</th>										
						</thead>	
	<!--#include file="../_fpclass/fpdblib.inc"-->
		
					<%
						dist=Request.Cookies("Distcd")'Session("Dist_cd")
						ccode=Request.Cookies("Catcd")
						'Response.write(dist)
						cat=Request.Form("sect")
						if Request.Form("namel") = "" then
							if Request.Form("namef") = "" then
								if Request.Form("sect") = "" then		
									s_no=0
									if(Catcd=CATCD_NATIONAL) then
										fp_sQry="SELECT PD1.* ,M_PARAM.Cat_name FROM PER_DETAILS AS PD1,M_PARAM WHERE ( PD1.Sno=" & s_no & " ) and M_PARAM.Cat_cd=PD1.Cat_cd and M_PARAM.Cat_typ='post' "
									else
										if ( Catcd=CATCD_DISTRICT) Then 
											fp_sQry="SELECT PER_DETAILS.* ,M_PARAM.Cat_name FROM PER_DETAILS,M_PARAM WHERE ( PER_DETAILS.Sno=" & s_no & " ) and M_PARAM.Cat_cd=PER_DETAILS.Cat_cd and M_PARAM.Cat_typ='post' and PER_DETAILS.Dist_cd='" & dist & "' "
										else
											fp_sQry="SELECT PER_DETAILS.* ,M_PARAM.Cat_name FROM PER_DETAILS,M_PARAM WHERE ( PER_DETAILS.Sno=" & s_no & " ) and M_PARAM.Cat_cd=PER_DETAILS.Cat_cd and M_PARAM.Cat_typ='post' and PER_DETAILS.Dist_cd=" & dist & " "
										end if
									end if
							Response.Write "first.."		
							Response.Write(Catcd)
							'Response.Write(fp_sQry)
								else
									if(Catcd=CATCD_NATIONAL) then
										fp_sQry="SELECT PD1.* ,M_PARAM.Cat_name FROM PER_DETAILS AS PD1,M_PARAM,postdetails WHERE ( M_PARAM.Cat_name like '" & cat & "' ) and M_PARAM.Cat_cd=postdetails.post_held and postdetails.slno_per_detail=PD1.Sno and M_PARAM.Cat_typ='post'"	
									else
										if (Catcd=CATCD_DISTRICT) Then 
											fp_sQry="SELECT PD1.* ,M_PARAM.Cat_name FROM PER_DETAILS AS PD1,M_PARAM,postdetails WHERE ( M_PARAM.Cat_name like '" & cat & "' ) and M_PARAM.Cat_cd=postdetails.post_held and postdetails.slno_per_detail=PD1.Sno and M_PARAM.Cat_typ='post' and PD1.Dist_cd ='" & dist & "' "
													
										else 
											fp_sQry="SELECT DISTINCT PD1.FirstName AS M_FirstName,PD1.MiddleName AS M_MiddleName,PD1.LastName AS M_LastName,PD1.*,PD2.FirstName AS SC_FirstName,PD2.MiddleName AS SC_MiddleName,PD2.LastName AS SC_LastName,MP1.Cat_name FROM PER_DETAILS AS PD1 ,PER_DETAILS AS PD2 ,M_PARAM AS MP1 ,M_PARAM AS MP2 ,postdetails AS po1 ,postdetails AS po2 WHERE ( MP1.Cat_name like '" & cat & "' ) and MP1.Cat_cd=po1.post_held and po1.slno_per_detail=PD1.Sno and MP1.Cat_typ='post' and (PD1.State LIKE 'TN%') AND PD1.City=PD2.City	AND PD2.Sno=po2.slno_per_detail AND MP2.Cat_typ='post' 	AND MP2.Cat_name LIKE 'DIST. MAHILA CO.(SPIRITUAL)' AND po2.post_held=MP2.Cat_cd"
			
										end if
									Response.Write "second.."
									Response.Write(Catcd)
									'Response.Write(fp_sQry)
										end if					
									end if
							else
								if Request.Form("sect") = "" then
									fp_sQry="SELECT PER_DETAILS.* ,M_PARAM.Cat_name FROM PER_DETAILS,M_PARAM WHERE ( firstName like '%::namef::%' ) and M_PARAM.Cat_cd=PER_DETAILS.Cat_cd and M_PARAM.Cat_typ='post' and PER_DETAILS.Dist_cd='" & dist & "' "
									
								else
									fp_sQry="SELECT PER_DETAILS.* ,M_PARAM.Cat_name FROM PER_DETAILS,M_PARAM,postdetails WHERE ( M_PARAM.Cat_name like '" & cat & "' AND firstName like '%::namef::%' ) and M_PARAM.Cat_cd=postdetails.post_held and postdetails.slno_per_detail=PER_DETAILS.Sno  and M_PARAM.Cat_typ='post' and PER_DETAILS.Dist_cd='" & dist & "' "
									
								end if
							end if
					else
						if Request.Form("namef") = "" then
							if Request.Form("sect") = "" then
								fp_sQry="SELECT PER_DETAILS.* ,M_PARAM.Cat_name FROM PER_DETAILS,M_PARAM WHERE ( LastName like '%::namel::%' ) and M_PARAM.Cat_cd=PER_DETAILS.Cat_cd and M_PARAM.Cat_typ='post' and PER_DETAILS.Dist_cd='" & dist & "' "
								
							else
								fp_sQry="SELECT PER_DETAILS.* ,M_PARAM.Cat_name FROM PER_DETAILS,M_PARAM,postdetails WHERE ( M_PARAM.Cat_name like '" & cat & "' AND LastName like '%::namel::%' ) and M_PARAM.Cat_cd=postdetails.post_held and postdetails.slno_per_detail=PER_DETAILS.Sno and M_PARAM.Cat_typ='post' and PER_DETAILS.Dist_cd='" & dist & "' "
								
							end if
						else
							if Request.Form("sect") = "" then
								fp_sQry="SELECT PER_DETAILS.* ,M_PARAM.Cat_name FROM PER_DETAILS,M_PARAM WHERE ( firstName like '%::namef::%' AND LastName like '%::namel::%' ) and M_PARAM.Cat_cd=PER_DETAILS.Cat_cd and M_PARAM.Cat_typ='post' and PER_DETAILS.Dist_cd='" & dist & "' "
								
							else
								fp_sQry="SELECT PER_DETAILS.* ,M_PARAM.Cat_name FROM PER_DETAILS,M_PARAM,postdetails WHERE ( M_PARAM.Cat_name like '" & cat & "' AND firstName like '%::namef::%' AND LastName like '%::namel::%' ) and M_PARAM.Cat_cd=postdetails.post_held and postdetails.slno_per_detail=PER_DETAILS.Sno and M_PARAM.Cat_typ='post' and PER_DETAILS.Dist_cd='" & dist & "' "
								
							end if
						end if
					end if 
					Response.Write("session dist_cd: "+Session("Dist_cd"))
					Response.Write(fp_sQry)
					fp_sDefault=""
					fp_sNoRecords="<tr><td colspan=30 align=left width=""100%"">No records returned.</td></tr>"
					fp_sDataConn="ssssoseva"
					'fp_iMaxRecords=256
					fp_iCommandType=1
					'fp_iPageSize=5
					fp_fTableFormat=True
					fp_fMenuFormat=False
					fp_sMenuChoice=""
					fp_sMenuValue=""
					fp_iDisplayCols=30
					fp_fCustomQuery=False
					BOTID=0
					fp_iRegion=BOTID
				%>
	<!--#include file="../_fpclass/fpdbrgn1.inc"-->	
					<tbody>
							<tr>
								<td>
									<%=FP_FieldVal(fp_rs,"Sno")%>
								</td>
								<td class="membersName">
									<span><%=FP_FieldVal(fp_rs,"M_FirstName")%></span>  <span><%=FP_FieldVal(fp_rs,"M_MiddleName")%></span> <span><%=FP_FieldVal(fp_rs,"M_LastName")%></span>
								</td>
								<td>
									<%=FP_FieldVal(fp_rs,"Address")%>
								</td>
								<td>
									<%=FP_FieldVal(fp_rs,"City")%>, <%=FP_FieldVal(fp_rs,"State")%>  
								</td>	
								<td class="convenerName">
									<span><%=FP_FieldVal(fp_rs,"SC_FirstName")%></span>  <span><%=FP_FieldVal(fp_rs,"SC_MiddleName")%></span> <span><%=FP_FieldVal(fp_rs,"SC_LastName")%></span>
								</td>
								<td>
									<%=FP_FieldVal(fp_rs,"MobilePhone")%>
								</td>													
								<td>
									<%=FP_FieldVal(fp_rs,"EmailAddress")%>
								</td>
								<td>
									<% if CBool(FP_Field(fp_rs,"Sex")) then %>Male<% else %>Female<% end if %>
								</td>							
								<td>
									<%=FP_FieldVal(fp_rs,"Occupation")%>
								</td>						
								<td nowrap="nowrap">
									<%=FP_FieldVal(fp_rs,"Reg_dt")%>
								</td>																					
							</tr>	
	<!--#include file="../_fpclass/fpdbrgn2.inc"-->	
						</tbody>
					</table>
				</div>
			</form>
		</div>
	</div>
	
	
	<script type="text/javascript"> 		
		$(".language, .skill").each(function(){
			var str = $(this).text()
							.trim()
							.replace(/,/g , ', ');
			$(this).text(str);			
		});
		
		$("#officeBearersOption").on("change", function(){
			$(".load").addClass("loading");
			$("#officeBearersForm").submit();
		});	

		//Extra space correction
		$(".membersName").each(function(){
			var name = $(this).text();
			var memberName = name.replace(/\./gi, ' ')
								.replace(/\s\s+/g, ' ');
			$(this).text(memberName);
		});
		
	</script>
</body>
</html>