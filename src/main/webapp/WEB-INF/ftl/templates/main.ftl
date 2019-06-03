<#macro main title>
<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
              integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link rel="stylesheet" href="/assets/style/base.css">
        <link rel="stylesheet" href="/assets/style/main.css">
        <link rel="stylesheet" href="/assets/style/style.css">
    <title>${title}</title>
    </head>
    <body>
        <#include "../parts/navbar.ftl">
                <#nested>
        <#include "../parts/footer.ftl">
    </body>
</html>
</#macro>