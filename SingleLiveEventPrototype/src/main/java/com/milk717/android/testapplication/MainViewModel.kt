package com.milk717.android.testapplication

import androidx.lifecycle.MutableLiveData

class MainViewModel: BaseViewModel() {

    /*SingleLiveEvent 를 사용하지 않고 이벤트를 처리할 때
    1. layout 에서 startMyEvent 를 호출함
    2. Boolean LiveData 인 myEvent 값이 바뀜.
    3. MainActivity 에서 myEvent 를 관찰하고 있다가 값이 변경된걸 알고 observe{} 안에 있는 명령 실행함.
    ## 여기서 발생하는 문제점은 myEvent 에 사용하지 않는 불필요한 값을 넣어주어야 한다.
    그리고 myEvent.value = ture, myEvent.value = false 일 때 모두 동작함.
    이 문제를 해결하는 방법이 SingleLiveEvent 를 사용하는 것!
     */
    val myEvent: MutableLiveData<Boolean> = MutableLiveData()
    fun startMyEvent(){
        myEvent.value = true
    }

    /*SingleLiveEvent 를 사용해서 이벤트를 처리할 때
    1. layout 에서 startMyEvent2를 호출함.
    2. myEvent2 가 call 됨.
    3. MainActivity 에서 myEvent2를 관찰하고 있다가 call 된것을 감지하고 observe{} 안에 있는 명령어 실행
    ## 불필요한 값을 넘겨주지 않아도 되기 때문에 아까 위의 문제를 해결할 수 있음.
    그런데 모든 이벤트마다 SingleLiveEvent 객체를 생성해야 하기 때문에 문제!!
     */
    val myEvent2 = SingleLiveEvent<Any>()
    fun startMyEvent2(){
        myEvent2.call()
    }

    /* Event 객체 사용할 때 == BaseViewModel 상속받기
      1. layout 에서 startMyEvent3를 호출함.
      2. viewEvent 함수에 이벤트에 해당하는 상수 전달함
      3. Event 객체 동작으로 이벤트 감지해서 실행됨. todo - 이거 잘 모르겠음.
      ## SingleLiveEvent 를 만들지 않아도 되고 여러 이벤트를 효과적으로 처리할 수 있다.
     */
    companion object{
        const val EVENT_START = 22212
    }
    fun startMyEvent3() = viewEvent(EVENT_START)
}