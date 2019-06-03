<#import "../templates/main.ftl" as main/>
<@main.main title="Страница администратора">
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
</@main.main>
