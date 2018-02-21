	<% if Request.Cookies("Distcd")="" then %>
		<!--#include File='../login/Login_Check.asp'-->
	<% end if %>

	<!--#include file="../inc/bsHtmlLayoutTop.inc"-->
	<!--#include file="../inc/bsNavbarTop.inc"-->
	<!--#include file="../inc/sidebarMembers.inc"-->
    <!--#include file="../_fpclass/sha/sha256.asp"-->

	<%Catcd=Request.Cookies("Catcd")%>	
	
	<div class="container-fluid">		
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h1 class="page-header">Manage Samitis</h1>	
            
			<div class="col-sm-12 col-lg-12 form-group">						
				<div>
					<label>
						<button id="addNewSamithi">Add New Samiti / BM</button>
					</label>
				</div>
			</div>
	        	
            <div id="tbl"></div>     
            
            <p>* denotes Bhajan Mandalis</p>       
		</div>
	</div>	
	
	<!--Add Samithi Modal-->
	<div class="modal fade" id="addSamitiModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Add New Samiti / BM</h4>
				</div>
				<form action="" method="post" id="addSamitiForm">																
					<div class="modal-body form-horizontal">
						<!--#include file="../inc/districtDropdown.inc"	-->				
						<input type="hidden" name="createdBy" value="<%Response.write(Request.Cookies("login"))%>">
						<div class="alert alert-info">
							<strong>Note:</strong>To add Bhajan Mandalis please use prefix *
						</div>
						<div class="form-group">
							<div class="col-sm-12">
							<label>New Samiti / BM</label>
								<input type="text" class="form-control" id="newSamiti" name="newSamiti" placeholder="Enter New Samiti" required="required">
							</div>
						</div>							
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-link" data-dismiss="modal">Cancel</button>					
						<button type="submit" class="btn btn-primary" id="addSamiti">Add Samiti / BM</button>					
					</div>
				</form>				
			</div>
		</div>
	</div>	
	
	
	<div id="infoModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Samiti Management</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default closeButton" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
    <script>
        <%
            ts = DatePart("yyyy",Date) _ 
                & Right("0" & DatePart("m",Date), 2) _ 
                & Right("0" & DatePart("d",Date), 2) _
                & Right("0" & DatePart("h",time), 2) _ 
                & Right("0" & DatePart("n",time), 2)

            qs = "distcd=" & Base64Encode(Request.Cookies("distcd"), false)
			
			'qs="samiti.asp?members"
			pagename="samiti.asp?members"

            'qslc = GenerateQSLCode(qs, pagename)
         %>
        var ajaxUrl = '/samiti/samiti.aspx?<%=qs%>&qslc=<%= PageMethods.GenerateQSLCode()%>';
		alert(ajaxUrl);

        $("#tbl").load(ajaxUrl, function() {
            $('#tbl .dtTbl').DataTable({
                'processing': true,
                'serverSide': true,
				'stateSave': true,
				'scrollX': true,
                'ajax': {
                    'url': ajaxUrl,
                    'type': 'POST',
                }
            });
        });
		
		$("body").on("change", "#stateOption", function(){
			$(".load").addClass("loading");
			var state = $(this).val();
			$.post("samiti.asp?state="+state, function(data){
				var district = $("#districtOption", data);
				$("#districtOption").replaceWith(district);
				$(".load").removeClass("loading");
			});
		});
		
		$("body").on("click", "#addNewSamithi", function(){
			$("#addSamitiModal").modal("show");			
		});
		
		$("#addSamitiForm").on("submit", function(e){
			var addSamithiurl = "/samiti/addSamiti.aspx?<%= qs %>&qslc=<%= GenerateQSLCode(qs, "addSamiti.aspx") %>"
			e.preventDefault();
			$.ajax({
				type: 'post',
				url: addSamithiurl,
				data:$("#addSamitiForm").serialize(),
				success: function(data){
					$("#addSamitiModal").modal("hide");
					if (data == "true") {
						$("#infoModal").find(".modal-body").html("Samithi saved successfully!")
						$("#infoModal").modal("show"); 
					} else if (data == "false") {
						$("#infoModal").find(".modal-body").html("Samiti already exist!")
						$("#infoModal").modal("show");						
					}					
				}
			});
		});
		
		$("body").on("click", ".closeButton", function(){
			window.location = window.location; 
		});
    </script>
</body>
</html>
