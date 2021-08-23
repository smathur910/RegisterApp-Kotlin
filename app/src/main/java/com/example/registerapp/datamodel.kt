package com.example.registerapp

class datamodel {

  private var img:Int
  private var desc:String

    constructor(img: Int, desc: String) {
        this.img = img
        this.desc = desc
    }

    fun getImage(): Int {
        return img
    }

    fun setImage(image: Int) {
        img = image
    }

    fun getDesc(): String? {
        return desc
    }

    fun setDesc(desc: String?) {
        this.desc = desc!!
    }


}