package dev.ogabek.kotlin

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(object: DebugTree(){
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                super.log(priority, "GLOBAL_TAG -:- $tag", message, t)
            }

            override fun createStackElementTag(element: StackTraceElement): String {
                return String.format(
                    "FileName : %s\tMethodName : %s\tLineNumber : %s",
                    element.fileName,
                    element.methodName,
                    element.lineNumber,
                    super.createStackElementTag(element)
                )
            }
        })
    }

}