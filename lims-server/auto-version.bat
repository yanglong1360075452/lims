@echo off
REM #
REM # LIMS��Ŀ�Զ��汾�����ű�
REM #
REM
REM ˵����
REM �˽ű������Զ�������ʽ������İ汾�š���maven����ִ�У���packageǰ/�����С�
REM
REM
REM ע��
REM �ű�ʹ��SubWCRev.exe����SVN�汾��Ϣ�Զ�������վ����İ汾�š�
REM ���TortoiseSVNδ��װ��ȱʡĿ¼��Ϊ��֤��������ͳһ���뵥����SubWCRev.exe�ļ�
REM ����һ�ݷ�����C:\Program Files\TortoiseSVN\bin\SubWCRev.exe��
REM


if "%1"=="prepare" goto prepare
if "%1"=="after" goto after

REM -------------------------------------------------------------------
echo #
echo # LIMS��Ŀ�Զ��汾�����ű�
echo #
echo=
echo �˽ű������Զ�������ʽ������İ汾�š���maven����ִ�У���packageǰ/�����С�
echo=
echo ���
echo     %0 prepare     - ��mvn prepare-package�׶α�����
echo     %0 after       - ��mvn package�׶δ����ɺ󱻵���

goto end


REM -------------------------------------------------------------------
REM 1.��mvn prepare-package�׶ε��ã�
:prepare
cd ../
REM 1.1.��ԭ���������е�version.js�ļ��ݴ�;
copy  .\lims-client\src\const\Version.vue  .\target-config\Version_dev.vue
REM 1.2.ͨ��SubWCRev���ɵ�ǰ�ķ�����İ汾��,������Version.vue�ļ�;
"C:\Program Files\TortoiseSVN\bin\SubWCRev.exe" .  .\target-config\version_template.txt .\lims-client\src\const\Version.vue
REM 1.3.ǰ�˴�������
cd .\lims-client
call npm run build
cd ..\
REM 1.4.ɾ��serverģ��webapp�ļ�����static�ļ��к�index.html
rmdir /s/q  .\lims-server\src\main\webapp\static\
rmdir /s/q  .\lims-server\src\main\webapp\index.html
REM 1.5.���Ƶ�serverģ��webapp�ļ�����
XCOPY .\lims-client\dist .\lims-server\src\main\webapp /S /Y
goto end


REM -------------------------------------------------------------------
REM 2.��mvn package�׶δ����ɺ���ã�
:after
cd ../
REM 2.1.�ָ�1.1�������ݴ��ԭ���������е�version.js�ļ���
move  .\target-config\Version_dev.vue .\lims-client\src\const\Version.vue
goto end


REM -------------------------------------------------------------------
:end
@echo on