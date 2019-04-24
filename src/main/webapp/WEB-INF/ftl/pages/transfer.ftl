<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<head xmlns:form="http://java.sun.com/jsf/html">
    <#--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"-->
          <#--integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">-->
    <title>Title</title>
    <#--<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">-->
    <#--<link rel="stylesheet" href="/static/style/style.css">-->
</head>
<h1>
    Transfer with CSRF example
</h1>
     <form action="/transfer" method="POST">
         <@spring.bind "transferForm"/>
         <label>Account Number</label>
         <input name="accountTo" type="number">
         <#--<@spring.formInput "transferForm.accountNo"/>-->
         <input name="amount" type="number"/>
         <#--<@spring.formInput "transferForm.amount"/>-->
         <input type="submit">
         <input type="hidden" name="csrfToken" value="${csrfToken}"/>
         <#--<@spring.formHiddenInput "transferForm.csrfToken"/>-->
         <@spring.showErrors "csrf"/>
     </form>
</div>
</body>
</html>
