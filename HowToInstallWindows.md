Windowsにおいて,Akiraの設定ファイルは C:Akira に保存される為，ディレクトリ C:Akira は必須です.
故にWindowsでは,Akira.jar も C:Akira に置く事を推奨します.
尚，JOGLは C:jogl に置くとして話を進めますが,JOGLの置き場所は自由です.


# Javaのインストール #
JREをインストールして下さい．

# JOGLのダウンロード #
最新版のJOGLは様々なバグを含んでいる為，必ず
http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/
からJOGLをダウンロードしてください．
**このJOGL以外を用いた場合の動作は保証しません．**
直リンクは以下です．
  * [Windows (64bit CPU)](http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/jogl-2.0-windows-amd64.zip)
  * [Windows (32bit CPU)](http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/jogl-2.0-windows-i586.zip)

Cドライブの直下に joglというフォルダを作り，
JOGLのlibの中身をコピーしておきます．
更にコントロールパネル-システム-詳細設定-環境変数にて,PATHに
```
C:jogl
```
を追加します．

# Akiraのダウンロード #
[download](http://code.google.com/p/project-akira/downloads/list)から
最新のAKira.zipをダウンロードしてください．
回答するとAkiraというフォルダが出来るので，
Cドライブの直下に置きます．

そして，同封のバッチファイルをPATHの通った場所に置いて下さい．

# 実行テスト #
[sample.zip](http://project-akira.googlecode.com/files/sample.zip)
をダウンロードし，解凍したディレクトリの中で，
```
AkiraConverter.bat
AkiraViewer.bat
```
をコマンドプロンプトから実行してみて下さい．


# フィードバック #
**ryo.kbys `[at]` gmail.com** まで一報ください．