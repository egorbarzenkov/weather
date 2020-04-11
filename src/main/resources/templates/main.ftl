<#import "parts/common.ftl" as c>

<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by city">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>

<div class="card-columns">
    <#if weather??>
        <div class="card my-3">
            <div class="m-2">
                <span>${weather.temp}</span>
            </div>
            <div>
                <i>${city.name}</i>
            </div>
        </div>
    <#else>
        No weather
    </#if>

</div>
</@c.page>
