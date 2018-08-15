<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table class="house-list">
	<a>不管怎样：有showList</a>
	<c:forEach items="${jsonModel.rows}" var="v">
		<tr>
			<td class="house-thumb"><span><a
					href="page/show.jsp?id=10001"><img src="images/thumb_house.gif" /></a></span></td>
			<td>
				<dl>
					<dt>
						<a href="house_detail.action/{v.id}">${v.title }</a>
					</dt>
					<dd>${v.description }</dd>
				</dl>
			</td>

			<c:if test="user.id==v.user_id">
				<td class="house-type"><label class="ui-green"><input
						type="button" onclick='update(10001)' value="修    改" /></label></td>
				<td class="house-price"><label class="ui-green"><input
						type="button" onclick='del(10001, 1)' value="删    除" /></label></td>
			</c:if>
			<c:if test="user.id!=v.user_id">
				<td class="house-type" colspan="2"></label></td>
			</c:if>

		</tr>
	</c:forEach>

</table>
<div class="pager">
	<ul>
		<li class="current"><a
			href="HouseBean_ajaxList.action?currPage=1""> 首页</a></li>
		<li class="current"><a
			href="HouseBean_ajaxList.action?currPage=1"> 上一页</a></li>
		<li class="current"><a
			href="HouseBean_ajaxList.action?currPage=1"> 下一页</a></li>
		<li class="current"><a
			href="HouseBean_ajaxList.action?currPage=1"> 尾页</a></li>
	</ul>
	<span class="total">${jsonModel.total%jsonModel.pageSize==0?jsonModel.total/jsonModel.pageSize:jsonModel.total/jsonModel.pageSize+1 }/${jsonModel.pages }页</span>
</div>