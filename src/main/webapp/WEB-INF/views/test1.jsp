<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
    <title>Test Page</title>
    <meta charset="UTF-8">


    </head>
    <body>
        Parameter Test Page...
        <form method="post" action="test1" >
            <table>
                <tr>
                    <td>name</td>
                    <td><input name="n" type="text"/></td>
                </tr>
                <tr>
                    <td>age</td>
                    <!--Notice, this is normal html tag, will not be bound to an object -->
                    <td><input name="age" type="text"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="send"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        ${n}
                    </td>
                </tr>
            </table>





        </form>



    </body>
</html>