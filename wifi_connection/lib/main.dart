import 'package:connectivity/connectivity.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  var result;
  GlobalKey materialKey = GlobalKey();
  @override
  Future<dynamic> getResult() async {
    var result = await Connectivity().checkConnectivity();
    return result;
  }

  @override
  void initState() {
    getResult().then((value) => this.result = value);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          centerTitle: true,
          title: Text("Internet Bağlantısı"),
        ),
        body: Center(
          child: TextButton(
            child: Text("Bağlan"),
            onPressed: () {
              setState(() {
                _checkConnectivity();
              });
            },
          ),
        ),
      ),
    );
  }

  _checkConnectivity() {
    if (result == ConnectivityResult.none) {
      print("no internet");
      _showDialog("İnternet yok", "İnternete bağlı değilsiniz");
    } else if (result == ConnectivityResult.mobile) {
      print("mobile");
      _showDialog("İnternete bağlandı", "Mobil veriye bağlanıldı");
    } else if (result == ConnectivityResult.wifi) {
      print("wifi");
      _showDialog("İnternete bağlandı", "Wifi bağlandı");
    }
  }

  _showDialog(String title, String text) {
    showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: Text(title),
            content: Text(text),
            actions: <Widget>[
              TextButton(
                child: Text("Tamam"),
                onPressed: () {
                  Navigator.of(context).pop();
                },
              )
            ],
          );
        });
  }
}
