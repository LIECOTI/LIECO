@echo off
echo ========================================
echo   LIECOTI Auto-Deploy to GitHub
echo ========================================
echo.

echo [1/3] Adding all files to Git...
git add --all
echo.

echo [2/3] Creating commit...
git commit -m "Deploy: %date% %time%"
echo.

echo [3/3] Pushing to GitHub main branch...
git push origin main --force
echo.

echo ========================================
echo   Deploy complete!
echo ========================================
pause
