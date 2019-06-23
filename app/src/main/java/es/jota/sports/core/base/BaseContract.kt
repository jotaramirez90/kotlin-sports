package es.jota.sports.core.base

interface BaseContract {

    interface View

    interface Broadcast

    interface Presenter<in T : View> {

        fun attachView(view: T)

        fun create() {}

        fun viewPrepared() {}

        fun postCreate() {}

        fun resume() {}

        fun pause() {}

        fun destroy()
    }
}