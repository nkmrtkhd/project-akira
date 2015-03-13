目次



---

# 注意 #
  * JavaVMを終了させてAkiraを終了させると，設定ファイルが保存されません．ESCを押すか，メニューバーから終了を選択して，終了させてください．

---

# 困ったときは #
  * 設定ファイルを消してみてください
  * 表示されるエラーを読んでください

---

# サンプル #
  1. [download](http://code.google.com/p/project-akira/downloads/list)から[sample.zip](http://project-akira.googlecode.com/files/sample.zip)をダウンロードします．
  1. 解凍します
  1. AkiraConverter.confは付属しているので，`Akira.sh sample.Akira`を実行します

---

# Converter #
```
AkiraConverter.sh
```
で起動します．


## 設定ファイル ##
必ずAkiraConverter.confという名前で，以下のように項目を順序で過不足なく書いておきます．
その際の注意点は以下です．
  * #でコメントアウト
  * 空白はどれだけ入れても良い
  * 順序を入れ替えないで下さい
```
#AkiraConv config file (starting with # is comment line)
#DON'T CHANGE ORDER OF ITEMS
#THE ORDER OF EACH ITEM IS IMPORTANT!!

#system name
sample

## read file (C like format)
#file-format:path:filename,startFrame,endFrame,Increment
### file-formats are;
###    akira, akiratgz, akiratbz2, akirabin, akirabintgz, akirabintbz2,
###    chgcar, cube, xyz, coord, xcrysden,
akiratgz:./input-samples/sio2.tgz:out%03d,0,51,10


### start time, time interval
0.0 1.0e0

### create bonds?
false
### bond info: tag1, tag2, length[your unit]
1 2 1.7
### create bonds with file?
false
### bonds file
bond000

### cut x?, min[0:1], max[0:1]
false 0.5 0.8
### cut y?, min[0:1], max[0:1]
false 0.4 0.6
### cut z?, min[0:1], max[0:1]
false 0.0 1.0
### cut sphere? radius[your unit], center[0:1]
false 10 0.5 0.5 0.5
```



各項目についての説明は以下です．

### 名前 ###
対象を表す名前をつけましょう．
```
#system name
sample
```
この場合，sample.Akiraというファイルが生成されます．

### ファイル指定 ###
読み込めるファイルフォーマットは以下の表です．

|**フォーマット**|**指定名**|
|:---------------------|:------------|
| [Akiraフォーマット](http://code.google.com/p/project-akira/wiki/AkiraFormat) |akira |
| [Akiraフォーマット](http://code.google.com/p/project-akira/wiki/AkiraFormat)+tgz |akiratgz |
<a href='Hidden comment: 
This text will be removed from the rendered page.
|| [http://code.google.com/p/project-akira/wiki/AkiraFormat Akiraフォーマット]+tbz2 ||akiratbz2 ||
|| [http://code.google.com/p/project-akira/wiki/AkiraFormat Akiraフォーマット(バイナリ出力)] ||akirabin ||
|| [http://code.google.com/p/project-akira/wiki/AkiraFormat Akiraフォーマット(バイナリ出力)]+tgz ||akirabintgz ||
|| [http://code.google.com/p/project-akira/wiki/AkiraFormat Akiraフォーマット(バイナリ出力)]+tbz2 ||akirabintbz2 ||
|| VASPのCHGCAR形式 ||chgcar ||
|| GaussianのCube形式 ||cube ||
|| XYZ形式 ||xyz ||
|| gnuplotで表示できる形式 ||coord ||
|| XCrysDen形式 ||xcrysden ||
'></a>
これらのファイルフォーマットと共に，ファイルが置いてあるディレクトリ，開始番号，終了番号，番号の増分

**ファイル指定の例**
  * カレントディレクトリにあるAkiraフォーマットで出力されたファイルout001, out002, ..., out010を読み込む場合
```
akira:./:out%03d,1,10,1
```
  * カレントディレクトリにAkiraフォーマットで出力されたファイルout001, out002, ..., out010があるが，out001, out003, out005, ..., out090を読み込む場合(<font color='red'>すなわち1飛ばし</font>)
```
akira:./:out%03d,1,10,2
```
  * Akiraフォーマットで出力されたファイルout0001, out0002, ..., out0100がtar+gzでa.tgzという名前で圧縮されており，a.tgzが一つ上のディレクトリにある場合
```
akiratgz:../a.tgz:out%03d,1,100,1
```
  * VASPで出力したCHGCARが~/Desktopにある場合
```
chgcar:~/Desktop:CHGCAR,1,1,1
```

### 時間間隔 ###
初期フレームの時間と各時間フレームの間の時間を指定します．
```
### start time, time interval
0.0 1.0e0
```

### ボンドについて ###
View時にもボンドを生成することが可能ですが，Convertの時点で生成しておくと時間を短縮できます．
#### 長さでボンドを生成する場合 ####
ボンド長はhマトリクスの長さで指定してください．
```
### create bonds?
false
### bond info: tag1, tag2, length[your unit]
1 2 1.7
```
#### ボンドをファイルで指定する ####
生成するボンドを各フレームファイル毎に指定することも出来ます．
その場合
```
### create bonds with file?
true
### bonds file
bond%03d
```
としてください．
さらに，各行にボンドを生成するペアを1からNの範囲で書いたファイルbond000, bond001,... を作ります．
例えば
```
2 3 4
3 4
9 10 11
```
とすると，原子1は2,3,4との，原子2は3,4との，原子3は9, 10, 11とのボンドを生成します．

### 領域カット ###
領域をカットする時に使います．
```
### cut x?, min[0:1], max[0:1]
false 0.5 0.8
### cut y?, min[0:1], max[0:1]
false 0.4 0.6
### cut z?, min[0:1], max[0:1]
false 0.0 1.0
### cut sphere? radius[your unit], center[0:1]
false 10 0.5 0.5 0.5
```


---


# Viewer #
```
AkiraViewer.sh sample.Akira
```
で起動します．

## キー操作 ##
| **キー** | **効果** |
|:-----------|:-----------|
| 矢印 | 回転 |
| shift+矢印 | 平行移動 |
| alt+矢印 | 回転(半分) |
| alt+shift+矢印 | 平行移動(半分) |
| meta+矢印 | 回転(二倍) |
| meta+shift+矢印 | 平行移動(二倍) |

## 基本操作 ##

## View Configuration ##

### Status ###
表示されているatomの数やboxサイズ，トータルフレームに対する現在のフレームが表示されます．
またFPS(Frame per Second)の設定も行います．
### Manipulation ###
回転や平行移動などをマウスで操作できます．

### Atoms ###
原子種ごとに大きさや色を設定します．
原子を選択することで，座標などの情報を表示できます．
また連続して選択すると，距離や角度を計算して表示します．

原子ラベルの表示の設定も行えます．

### Data ###
補助データのデータレンジを決めます．
このレンジに従ってカラーテーブルのレンジが決まります．

カラーテーブルのlegendや数値の書式も設定します．
  * legendには日本語も使えます．
  * 数値書式は，C言語の書式を使います．

### Boundary ###
表示する範囲を，a,b,c軸方向で指定します．
また，平面（法線ベクトルとある1点）でのカットも可能です．

### Bond ###
ボンドを表示します．
ボンドはAkiraConverterで生成しておくと楽ですが，動的にボンドを生成することも可能です．
ボンドの色は原子種，ボンド長，配位数によって決定されます．

### Color Table ###
カラーバーの種類を選択します．
カラーバーの位置も変更できます．

### Annotation ###
背景色やBox, Axis, time-legend，フォントを変更します．
systemに存在しJavaから使えるフォントをリストアップしているので，多彩なフォントを選択することが出来るはずです．
また**日本語フォントも指定できます**．

### Volume rendering ###
補助データから等値面を書くことが出来ます．

**使い方**

View Configurationウインドウでvolume panelを選びます．

<a href='http://wiki.project-akira.googlecode.com/git/img/manual/volume-panel.png'><img src='http://wiki.project-akira.googlecode.com/git/img/manual/volume-panel.png' /></a>

  * Data
で，描きたい補助データを指定します．
  * Range
で，補助データのmaxとminを指定します．Load Original Rangeを押すと，補助データのmaxとminをセットします．
  * Isosurface
とは等値面を描きます．レベルは先に設定したmaxとminで正規化された値(0から1)で指定します．
  * Contour
とは法線とある1点を与えることで指定される平面内での分布を描きます．
contourの解像度はDraw Meshに依存します．その際はcontourのポイントサイズをContour Point Sizeで調節して下さい．

最後に
  * Applyボタン
を押します．GUI操作を**自動的に**反映させるには，重すぎる処理なのでApplyボタンを押さなければ反映させないようにしています．


注意点．

補助データは，原子一つ一つのデータであるのでバラツキが大きくなんらかの平均をしなければ，見るに耐えません．
しかし，滑らかな描画の為には高い解像度が必要です．この相反する要求を満たすために，
まず平均用のメッシュ(data mesh) で補助データを平均します．
そして描画用のメッシュ(draw mesh) をdata meshから生成し，draw meshに基づいてデータを描画します.
  * Data Mesh
  * Draw Mesh
で，a, b, c方向の分割数を指定してください．

  * Data Meshは生データよりも細かい分割にしても，意味がありません．
  * Draw Meshはメモリの許す限り細かくすることができますが，処理に時間がかかるのでお勧めしません．


### Vector ###
任意に選んだ3つの付加データを成分として，ベクトルを描きます．
たとえば，力の三成分を与えた場合，力をベクトルとして描くことが出来ます．

### Combo ###
定型処理を行います．
そのリストはテキストエディタでも編集できます．

### Trajectory ###
Trajectoryパネルで，trajectory modeをオンにします．
原子を選択して，フレームを遷移させてください．


### Plane ###
平面を描きます．



---

# 逆引き #
## ムービーをつくる ##
W(wではない）を押すと全フレーム分のスナップショットを出力します．
よって，ムービーを作るには，
  1. 最適な視点にする
  1. Wを押す
  1. 画像を統合する
という手順になります．
画像を統合してムービーを作るには，様々なソフトがあると思います．

例えばImageMagickを使うのであれば，
```
convert -delay 20 *.png result.mpg
```
などとすれば，ムービーになります．