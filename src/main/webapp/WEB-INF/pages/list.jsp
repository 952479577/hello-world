<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "house_list.action",
			data : "pages=1&pageSize=10",
			dataType : 'HTML',
			success : function(data) {
				$("#houseArea").html(data);
			}

		});
	})
</script>

<a>不管怎样 有list了</a>
<c:if test="${user!=null }">
	<script>
		function add(){
			document.location="user/house_toAdd.action";
		}
	</script>
	<div class="search">
		<label class="ui-green"><input onclick="add()" type="button"
			name="search" value="发布房屋信息" /></label> 
		<label class="ui-green"><input
			type="button" name="search" value="退       出"
			onclick='document.location="index.jsp"' /></label>
	</div>
</c:if>
<div class="main wrap">
	<div id="houseArea">
		<%@ include file="showList.jsp"%>
	</div>
</div>


<%@ include file="bottom.jsp"%>
