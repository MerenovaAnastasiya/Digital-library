<!DOCTYPE html>
<head>
</head>
<body>
    <table>
        <tr>
            <th>
                Номер заказа
            </th>
            <th>
                Статус
            </th>
        </tr>
        <#list orders as order>
             <tr>
                 <#if order.id??>
                 <td>${order.id}</td>
                 <#if order.status??>
                <td>${order.status}</td>
                 </#if>
                 </#if>
             </tr>
        </#list>
    </table>
</body>
</html>
