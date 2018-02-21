	<% if Request.Cookies("Distcd")="" then %>
		<!--#include File='../login/Login_Check.asp'-->
	<% end if %>

	<!--#include file="../inc/bsHtmlLayoutTop.inc"-->
	<!--#include file="../inc/bsNavBarTop.inc"-->
	<!--#include file="../_fpclass/sha/sha256.asp"-->	

    <%
        Catcd=Request.Cookies("Catcd")
        ts = DatePart("yyyy",Date) _ 
            & Right("0" & DatePart("m",Date), 2) _ 
            & Right("0" & DatePart("d",Date), 2) _
            & Right("0" & DatePart("h",time), 2) _ 
            & Right("0" & DatePart("n",time), 2)

        qs = "cmd=download_csv&amp;distcd=" & Base64Encode(Request.Cookies("distcd"), false) & "&t=" & ts
        %>
	
	<div class="container-fluid">		
		<!--#include file="../inc/sidebarDashboard.inc"-->
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h1 class="page-header">Data Report</h1>	      	
            <p>Download: <a href="vc2017_datareport.aspx?<%= qs %>&qslc=<%= GenerateQSLCode(qs, "vc2017_datareport.aspx")%>">CSV</a></p>

			<div id="tbl" class="datasheet"></div>             
		</div>
	</div>	
	
    <script>
        <%
            qs = "distcd=" & Base64Encode(Request.Cookies("distcd"), false) _
                    & "&t=" & ts
        %>
        var ajaxUrl = '/etc/vc2017_datareport.aspx?<%= qs %>&qslc=<%= GenerateQSLCode(qs, "vc2017_datareport.aspx") %>';

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
		
		
    </script>
</body>
</html>
