<#import "parts/common.ftl" as c>

<@c.page>
<h5>История запросов</h5>
<#--<div>скоро что то будет</div>-->
<div class="card-columns">
    <#list histories as history>
        <div class="card my-3">
            <div class="m-2">
                <span>${history.city}</span>
            </div>
        </div>
    <#else>
    No message
    </#list>
</div>
</@c.page>
