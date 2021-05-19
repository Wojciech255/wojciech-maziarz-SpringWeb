call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser

echo there were errors
goto end

:browser
"C:\Program Files\Google\Chrome\Application\chrome.exe" https://wojciech255.github.io/

:end