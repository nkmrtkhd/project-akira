<font color='red'><b>Akiraの設定ファイルは，~/Akiraに保存されます．<br>
このディレクトリはコードを書き換えて，再コンパイルしなければ変更できませんので注意してください．</b>

以下の解説では，~/Akiraにすべてのファイルを置くことを前提として話を進めます．<br>
</font>

# Javaのインストール #
Macの場合は標準でインストールされていると思います．
ソフトウエアアップデートで最新版にして下さい．
Linuxの人はJREをインストールして下さい．

# Akiraのインストール #
[download](http://code.google.com/p/project-akira/downloads/list)から最新版のAkira-XXX.zipをダウンロードします．
解凍すると，Akiraというフォルダができると思います．
そのディレクトリに移動して，`make install`を実行します．
```
 $ cd ~/somewhere/Akira
 $ make install
```
このスクリプトは，`~/Akira`ディレクトリを作成し，Akiraパッケージ内の必要なファイル（バイナリファイルやスクリプトなど）をそこへコピーします．
その際，`~/.bashrc`へ
```
export PATH=$PATH:~/Akira/shellscript-mac
```
のような一文を書き込みます．Linuxでは最後のところが`mac`でなく`linux`となっているはずです．
bashでなく，tcshやzshなどの他のシェルを使っている人は各自で上記のパスの設定を行ってください．
また，`~/.bash_profile`内に，`source ~/.bashrc`という一文が存在しないと次回のログイン次に上記の設定が反映されないので，書いておく必要があります．

# JOGLのインストール #
必ず
http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/
からJOGLをダウンロードしてください．
<font color='red'><b>このJOGL以外を用いた場合の動作は保証しません．</b></font>
直リンクは以下です．
  * [MacOSX(universal)](http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/jogl-2.0-macosx-universal.zip)
  * [Linux (64bit CPU)](http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/jogl-2.0-linux-amd64.zip)
  * [Linux (32bit CPU)](http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/jogl-2.0-linux-i586.zip)

JOGLをダウンロードして，解凍します．
そしてその中にある**lib** を，**jogl** と名称変更して`~/Akira`ディレクトリに置きます．つまり，
```
$ cd ~/somewhere/jogl-2.0-macosx-universal
$ cp -r ./lib ~/Akira/jogl
```
結果として，以下のようになっているはずです．
```
$ ls ~/Akira/jogl
gluegen-rt-cdc.jar              jogl.gles1.cdc.jar              libgluegen-rt.so                nativewindow.core.jar
gluegen-rt.jar                  jogl.gles1.dbg.cdc.jar          libjogl_cg.jnilib               nativewindow.x11.cdc.jar
jogl.all-noawt.jar              jogl.gles1.dbg.jar              libjogl_cg.so                   nativewindow.x11.jar
jogl.all.cdc.jar                jogl.gles1.jar                  libjogl_es1.jnilib              newt.all-noawt.jar
jogl.all.jar                    jogl.gles2.cdc.jar              libjogl_es1.so                  newt.all.cdc.jar
jogl.awt.jar                    jogl.gles2.dbg.cdc.jar          libjogl_es2.jnilib              newt.all.jar
jogl.cg.jar                     jogl.gles2.dbg.jar              libjogl_es2.so                  newt.awt.jar
jogl.core.cdc.jar               jogl.gles2.jar                  libjogl_gl2.jnilib              newt.broadcomegl.cdc.jar
jogl.core.jar                   jogl.glu.gl2.jar                libjogl_gl2.so                  newt.broadcomegl.jar
jogl.egl.cdc.jar                jogl.glu.mipmap.cdc.jar         libjogl_gl2es12.jnilib-nouse    newt.core.cdc.jar
jogl.egl.jar                    jogl.glu.mipmap.jar             libjogl_gl2es12.so              newt.core.jar
jogl.gl2.dbg.jar                jogl.glu.tess.cdc.jar           libnativewindow_awt.jnilib      newt.ogl.cdc.jar
jogl.gl2.osx.jar                jogl.glu.tess.jar               libnativewindow_awt.so          newt.ogl.jar
jogl.gl2.win.jar                jogl.sdk.jar                    libnativewindow_jvm.jnilib      newt.osx.cdc.jar
jogl.gl2.x11.jar                jogl.util.awt.jar               libnativewindow_jvm.so          newt.osx.jar
jogl.gl2es12.osx.cdc.jar        jogl.util.cdc.jar               libnewt.jnilib                  newt.win.cdc.jar
jogl.gl2es12.osx.jar            jogl.util.fixedfuncemu.cdc.jar  libnewt.so                      newt.win.jar
jogl.gl2es12.win.cdc.jar        jogl.util.fixedfuncemu.jar      nativewindow.all.cdc.jar        newt.x11.cdc.jar
jogl.gl2es12.win.jar            jogl.util.gl2.jar               nativewindow.all.jar            newt.x11.jar
jogl.gl2es12.x11.cdc.jar        jogl.util.jar                   nativewindow.awt.jar
jogl.gl2es12.x11.jar            libgluegen-rt.jnilib            nativewindow.core.cdc.jar
```



# 実行テスト #
[sample.zip](http://project-akira.googlecode.com/files/sample.zip)
をダウンロードし，
解凍したディレクトリの中で，以下を実行してください．
```
$ Akira.sh sample.Akira
```
Akiraが起動すれば成功です．後はいろいろと使ってみてください．


# フィードバック #
ご意見，ご要望がありましたら，[コチラ](http://code.google.com/p/project-akira/issues/list)までよろしくお願いします．
ユーザからの声はデベロッパのモチベーションになるので，お気軽にどうぞ．