(ns easy-button.core
  (:gen-class)
  (:import (com.pi4j.io.gpio.event GpioPinDigitalStateChangeEvent GpioPinListenerDigital)
           (com.pi4j.io.gpio GpioFactory RaspiPin PinPullResistance)))


(defn event-listener [f]
  (when (fn? f)
    (reify
      GpioPinListenerDigital
      (^void handleGpioPinDigitalStateChangeEvent [this ^GpioPinDigitalStateChangeEvent event]
        (f event)))))

(defn handle-button-press [event]
  (println "button pushed"))


(defn -main
  "detect easy button push"
  [& args]
  (println "Hey")
  (let [gpio (GpioFactory/getInstance)
        button (.provisionDigitalInputPin gpio RaspiPin/GPIO_02 PinPullResistance/PULL_DOWN)]
    (.setShutdownOptions button true)
    (.addListener button (event-listener handle-button-press))

  (while true
    (.sleep Thread 500)
  )))



