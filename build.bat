@echo off
echo Compilando arquivos Java...

REM Caminho para o código-fonte
set SRC_PATH=src\main\java

REM Diretório de saída para os arquivos compilados
set OUT_PATH=out

REM Cria o diretório de saída se não existir
if not exist %OUT_PATH% mkdir %OUT_PATH%

REM Compila os arquivos .java
javac -d %OUT_PATH% %SRC_PATH%\personal\project\utils\*.java ^
                  %SRC_PATH%\personal\project\controller\*.java ^
                  %SRC_PATH%\personal\project\model\*.java ^
                  %SRC_PATH%\personal\project\view\*.java ^
                  %SRC_PATH%\personal\project\AppConfig.java ^
                  %SRC_PATH%\personal\project\Main.java

REM Verifica se a compilação teve sucesso
if %errorlevel% neq 0 (
    echo Erro na compilação!
    pause
    exit /b %errorlevel%
)

echo Criando arquivo JAR...

REM Diretório de saída do JAR
set DIST_PATH=dist

REM Cria o diretório dist se não existir
if not exist %DIST_PATH% mkdir %DIST_PATH%

REM Cria o arquivo JAR com o manifest
jar cfm %DIST_PATH%\music_helper.jar manifest.txt -C %OUT_PATH% .

REM Verifica se o JAR foi criado com sucesso
if %errorlevel% neq 0 (
    echo Erro ao criar o JAR!
    pause
    exit /b %errorlevel%
)

echo Concluído! O arquivo JAR está em: %DIST_PATH%\music_helper.jar
pause
