[English Instruction](EnglishInstruction.md)

# Akiraとは #
Akiraとは，ハイブリッドシミュレーション向けの可視化ソフトです．

名前は，微小な対象を拡大して観察する装置，顕微鏡の'顕'に由来します．


# 特徴 #
  * Javaで書かれているため，プラットホームに依存する事なく実行できます．
  * グラフィックスライブラリはOpenGLを利用しています．
  * 多数のファイルを読み込み，時間変化をアニメーションとして表示できます．
  * 動画作成の為のシーケンシャルな画像出力が簡単に行えます．
  * 容易なバッチ処理が可能です．
  * ボロノイ多面体が描けます．
  * アニメ風の描画により，柔らかな質感の絵を作成可能です．

[![](http://wiki.project-akira.googlecode.com/git/img/screen/screen1-small.png)](http://code.google.com/p/project-akira/wiki/ScreenShots)

[more screenshots...](http://code.google.com/p/project-akira/wiki/ScreenShots)

# システム条件 #
  * Java 1.5以上
  * JOGL (JavaからOpenGLを使う為のライブラリ)
が必要です．

# ちょっと試してみる #
[sio2.AKira(サンプルデータ)](http://project-akira.googlecode.com/files/sio2.Akira)をダウンロードして，
[Akira.jnlp](http://www2.pf-x.net/%7Enkmrtkhd/jnlp/akira-v2/Akira.jnlp)をクリックすると，AkiraViewerが起動します．
ダウンロードしたsio2.AKiraを選択すると，Akiraが使えます．


# インストール #
Akiraは，JavaとJOGLがインストールされていれば，Akira.jar（とシェルスクリプト）を設置するだけで利用出来ます．
JavaやJOGLのインストールも含めたインストールの方法を以下に示します．
  * [Mac/Linuxの場合](http://code.google.com/p/project-akira/wiki/HowToInstallMacLinux)
  * [Windowsの場合](http://code.google.com/p/project-akira/wiki/HowToInstallWindows)

直感的なユーザーインターフェースを目指していますが，詳細な説明を[マニュアル](Manual.md)に記述しています．

またbug fixや改良のために，開発に参加してみたいという人は，[開発心得](http://code.google.com/p/project-akira/wiki/ForDeveloper)を一読してください．．

# お願い #
Akiraを用いて作成した図を学術論文などに掲載する場合は[以下の論文](http://www.jstage.jst.go.jp/article/jccj/10/2/10_59/_article/-char/ja/)を引用してください（義務ではないです）．
```
ハイブリッドシミュレーションに適応した可視化ソフトウェアAkiraの開発
中村 貴英, 河野 貴久, 小林 亮, 尾形 修司,
Journal of Computer Chemistry, Japan, Vol. 10, No. 2, 59-68 (2011).
```



# Akiraの開発史 #
Akiraは，[尾形先生](http://locs.bw.nitech.ac.jp/mediawiki/index.php/メインページ)の先輩である[中野先生](http://physics.usc.edu/Faculty/Nakano/)の研究室で，C言語とOpenGL(glut)を使って開発されたatoms viewerというソフトウエアが起源となっています．
このatoms viewerを河野さんがJAVAに移植しKVS(Kouno Viewer System)の名前でしばらく使われていました．
それをもとに中村が書き直し，現在に至ります．
現在は，名古屋工業大学の[尾形研](http://locs.bw.nitech.ac.jp/mediawiki/index.php/メインページ)の有志によって改良・保守されています．

またAkiraはJAVAとOpenGLによって作られています．

2008以前: atomsviewerが使われる. <br>
2008-12-04: KVS開発スタート. <br>
2009-07-08: KVS開発終了．KVS2開発スタート. <br>
2010-11-28: 外部公開に向けて，KVSからAkiraへ改名．マニュアル整備． <br>
2010-12-26: ホスティングサーバーをGoogle Project Hostingへ． <br>
2011-08-07: バージョン管理をMercurialからgitへ． <br>


<h1>Contact</h1>
<b>ryo.kbys <code>[at]</code> gmail.com</b>