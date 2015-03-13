自前で修正したり，開発に参加してくれる人向けの資料です

目次


資料
  * [ディレクトリ構造の解説](http://code.google.com/p/project-akira/wiki/Source)
  * [JavaDoc](http://wiki.project-akira.googlecode.com/git/javadoc/index.html)


---

# How to Compile on OSX/Linux #
## ソースコードの入手 ##
gitを使って
```
git clone https://code.google.com/p/project-akira/ 
```
を実行します．
## 設定 ##
JOGL\_LIBという環境変数にjoglのライブラリを置いた場所を指定して下さい．
例えば，
```
export JOGL_LIB=~/myLocal/javalib/jogl
export DYLD_LIBRARY_PATH=$JOGL_LIB:$DYLD_LIBRARY_PATH
```
を.bashrcか.bash\_profileに追記するということです．

## コンパイルテスト ##
build.xmlのあるディレクトリで
```
ant
```
とすると，Akiraがコンパイルされ，実行されます．
JOGL\_LIBの設定が失敗している場合，実行されません．
もう一度JOGL\_LIBの設定を見直してください．

## 実行形式の生成 ##
```
ant jar
```
としてjarファイルを作ります．


---

# How to Compile on Windows #
## ソースコードの入手 ##
gitを使って
```
git clone https://code.google.com/p/project-akira/ 
```
を実行します．

## JDKのインストール ##
JDKをインストールします(JREではありません)．
コントロールパネル-システム-詳細設定-環境変数にてJAVA\_HOMEの値を
```
C:Program Files\Java\jdk******** (←インストールされた場所)
```
として自分で設定します．さらにPathにJAVA\_HOME\verb|\|binを追加
(なぜこのくらいの設定をインストーラーでやってくれないのか．．．)
## ant ##
antをダウンロードして，内容物をすべて
```
C:Program Files\ant
```
に入れます．
更にコントロールパネル- システム-詳細設定-環境変数にて
ANT\_HOMEの値を
```
C:Program Files\ant
```
として自分で設定します
さらにPathに\%ANT\_HOME\% \verb|\|binを追加
## build.xmlの書き換え ##
環境変数\verb|JOGL\_LIB|を設定しても，antでうまく処理してくれないので，
build.xmlを直接変更します．build.xmlの先頭にある
```
<property name="jogl_dir"  value="\${env.JOGL_LIB}" />
```
を
```
<property name="jogl\_dir"  value="\jogl2" />
```
に書き換えます．

# How to Contribute #
パッチを作って送ってください．
修正のためのブランチを作り，コードを修正して
```
git format-patch
```
とすると，パッチが生成されます．
このパッチを送ってください．