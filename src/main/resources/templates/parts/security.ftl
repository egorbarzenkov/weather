<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isAdmin = user.isAdmin()
        isActive = user.isActive()
    >
<#else>
    <#assign
        isActive = false
        name = "unknown"
        isAdmin = false
    >
</#if>
