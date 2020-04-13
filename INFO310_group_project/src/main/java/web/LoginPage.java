/**
 * INFO310
 * LoginPage.java
 * initial/basic setup for login page, not yet connected to database
 * @author Julia McDowell
 * /
 
<html>
    <head>
        <title>Login Page</title>
    </head>

    <style>

    body {
        font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
        font-size: 14px;
        line-height: 1.5;
        font-weight: 400;
        border-top: 5px solid #f9c000;
    }
    </style>


    <body>
        <div id="loginsection">
            <h1>Login Page</h1>
            <form action="Login">
                <label for="un"><b>Username:</b></label>
                <input type="text" name="un" required/><br>
                <label for="pw"><b>Password:</b></label>
                <input type="text" name="pw" required/><br>
                <input type="submit" value="Submit">
                <input type="button" value="Create Account">
                <input type="button" value="Forgot Password">
            </form>
        </div>
    </body>
</html>
            