ソースコードの構造を説明します．


# Directory: project-akira/ #
AkiraはAkiraConverterとAkiraViewerで構成されます．
主要な構成ファイルの特徴を述べます．
これにより，Akiraの全体像を把握しやすくなることを期待します．
AkiraConverter.javaとAkiraViewer.javaがメインファイルです．


AkiraConverterで使うクラスはconverter/に，
AkiraViewerで使うクラスはviewer/に格納されています．
共通して使うクラスはdata/やtools/に格納されています．

|**file/dir name**|**description**|
|:----------------|:--------------|
|AkiraConverter.conf|開発用のAkiraConverter設定ファイル|
|build.xml|ant用のファイル．makefileみたいなもの．|
|converter|AkiraConverter用のファイルが格納されている|
|data/|基本データのクラスが格納されている|
|img/|Akiraで使うimageファイルが格納されている|
|input-samples/|開発用のサンプルファイル|
|jar-libs/|Akiraで用いるライブラリファイルが格納されている|
|make-package.sh|公開用のファイルを作るスクリプト|
|manual/|このマニュアルを生成するtexファイルが格納されている|
|rotation.AkiraCmb|コンボモードのサンプルファイル|
|tools/|AkiraConverterとAkiraViewerで共通して使うクラスが格納されている|
|utils/|プラットホーム別のスクリプト|
|viewer/|AkiraViewer用のクラスが格納されている|

## data/ ##
|**file/dir name**|**description**|
|:----------------|:--------------|
|Atoms.java | 原子のクラスファイル|
|Bond.java | ボンドのクラスファイル|
|Bonds.java | ボンドをまとめるためのクラスファイル|
|Const.java | 定数を定義してあるファイル|

## converter/ ##
|**file/dir name**|**description**|
|:----------------|:--------------|
| AkiraConverter.conf | AkiraConverter用の設定ファイル |
| AkiraConverter.java | AkiraConverterのメインクラス |
| ConfCreater.java | AkiraConverter用の設定ファイルを生成するクラス |
| ConvConfig.java | AkiraConverter.confを読み込んで，値を保存するクラス |
| Tool.java | AkiraConverterで使う関数 |
| reader/ | 各種データフォーマット別の読み込み関数 |

## viewer/ ##
|**file/dir name**|**description**|
|:----------------|:--------------|
| AkiraViewer.java | main関数があるクラス．Look&Feelも設定する． |
| BackRenderingWindow.java | 後ろからの描画を行うクラス． enjoyモードで使用． |
| Controller.java | 実質的なmainクラス．このクラスが全クラスを保持している． |
| KeyController.java | キーボード操作を統括する |
| LF/ | Look&Feel関係のクラスが置いてある． |
| RenderingWindow.java | 描画が行われるメインウインドウ． |
| RenderingWindowMenuController.java | RenderingWindowのメニューを管理． |
| SplashWindow.java | AkiraViewerが起動する時のスプラッシュウインドウ． |
| UpdateManager.java | Updateを管理する． |
| ViewConfig.java | AkiraViewerの設定が保持されるクラス． |
| ViewConfigWindow.java | AkiraViewerの設定を変更するためのウインドウ |
| ViewConfigWindowMenuController.java | ViewConfigWindowのメニュー |
| informationPanel/ | InformationWindowの各パネル． |
| keys.html | keyのヘルプファイル |
| renderer/ | 機能別のrenderingクラスが格納されている |
| viewConfigPanel/ | 設定を変更する為の各種パネル |

## tools/ ##

|**file/dir name**|**description**|
|:----------------|:--------------|
| BondCreator.java | ボンドを生成するクラス |
| Coordinate.java | xyz座標から曲座標系への返還 |
| Exponent.java  | 文字列解析 |
| InvMat.java | 逆行列計算 |
| LUDecomposition.java | 逆行列計算 |
| MyColorEditor.java | color editor|
| MyColorRenderer.java | color editor|
| MyFileIO.java | Akiraファイル用のFile IO |
| MyFilter.java | Openダイアログ用のフィルタ |
| MyOpen.java | AkiraViewerでのOpenダイアログ |
| PairList.java | リストを生成する |
| SlideInNotification.java | スライドインする警告を実装している |
| Tokens.java | 文字列分解用のクラス |
| colorpicker/ | colorpicker用のクラス |

## jar-lib/ ##

|**file/dir name**|**description**|
|:----------------|:--------------|
| BareBonesBrowserLaunch.jar | webブラウザを立ち上げる為に必要なライブラリ |
| TableLayout.jar | レイアウト用のライブラリ |
| ant.jar | アーカイブされたファイルを読み込む為に必要なもの |
| forms-1.2.1.jar | RenderingWindowで使うステータスバー用のライブラリ |
| jlibeps.jar | epsファイルを出力する為のファイル |


---

# Akira Converter #
mainクラスはAkiraConverter.javaです．
このクラスが，データを読み込み，Akiraファイルに書き出します．

新たなデータフォーマットに対応するには，converter/reader以下にクラスを追加します．
新たに作るクラスの至上目的はAtomsクラスに値をセットする事です．
具体的には，h-matirx，原子種，座標，補助データをセットします．
**セットする座標は実座標であることに注意してください．**

## converter/reader/ ##
各種データフォーマットに対応した読み込みクラスが集まっています．
AkiraAscii.javaがスタンダードな読み込みクラスなので，新たに追加する場合はこれを参考にしてください．


# Akira Viewer #
メインクラスはAkiraViewer.javaです．
起動順は
  1. AkiraViewer
  1. Controler
  1. ViewConfigWindow
  1. RenderingWindow
です．この順に読んでください．これらの機能は

| AkiraViewer | Look&Feelや，コマンドラインオプションを解析 |
|:------------|:-------------------------------------------------------------|
| Controler | 実質的なメイン |
| RenderingWindow| 描画 |
| ViewConfigWindow | 設定ファイルを編集 |

重要なファイルに対するコメントは以下です．
## Controler.java ##
各クラスはこのControllerクラスを経由して他のクラスの変数やメソッドを利用します．
## View Config.java ##
Viewerの設定変数が格納されているクラス．
これは丸ごと保存されます．
この値はViewerConfigWindowで編集されます．
## Rendering Window.java ##
OpenGLのセットアップを始め，実際に描画するメソッド(display)を持ちます．
新たに描画メソッドを追加したら，このクラスも修正しなければ反映されません．
各種描画メソッドの詳細はJavaDocを参照してください．
  1. RenderingWindow(); コンストラクタ
  1. initialize(); init()の前に呼ばれる
  1. init(); OpenGLが呼ぶ
  1. display(); 描画ルーチン
の順で読むとよいでしょう．