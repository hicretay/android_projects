import 'package:flutter/material.dart';
import 'package:yasam_suresi_uygulamasi/constants.dart';

class IconWidget extends StatelessWidget {
  final String cinsiyet;
  final IconData icon;

  IconWidget({this.cinsiyet, this.icon});

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Icon(icon, size: 50, color: Colors.black54),
        SizedBox(height: 10),
        Text(
          cinsiyet,
          style: kMetinStili,
        )
      ],
    );
  }
}
