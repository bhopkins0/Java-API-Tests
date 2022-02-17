<?php

if ($_SERVER["REQUEST_METHOD"] == "POST" && $_POST["key"] == "exampleKey" && $_SERVER["HTTP_USER_AGENT"] == "api-testing 1.0") {

if ($_POST["action"] == "getTime") {
echo "The date and time is: ".date(DATE_RFC2822);
die();
}

if ($_POST["action"] == "getIP") {

if (isset($_SERVER["HTTP_CF_CONNECTING_IP"])) {
  $_SERVER['REMOTE_ADDR'] = $_SERVER["HTTP_CF_CONNECTING_IP"];
}

echo "The IP accessing the API is ". $_SERVER["REMOTE_ADDR"];
die();

}
echo "Invalid API action";
}

header('HTTP/1.1 403 Forbidden');
echo "<h1>403</h1>";
die();
?>
