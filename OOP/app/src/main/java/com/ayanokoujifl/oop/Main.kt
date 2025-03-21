package com.ayanokoujifl.oop

import com.ayanokoujifl.oop.worker.Business
import com.ayanokoujifl.oop.worker.Developer

/*
* 11. Desafio
Na classe SmartDevice, defina um método printDeviceInfo() que mostra uma string "Device name: $name,
*                                    category: $category, type: $deviceType".
Na classe SmartTvDevice, defina um método decreaseVolume() para diminuir o volume e um método
*                                     previousChannel() que navega até o canal anterior.
Na classe SmartLightDevice, defina um método decreaseBrightness() que diminui o brilho.
Na classe SmartHome, faça com que todas as ações possam ser realizadas apenas quando a propriedade
* deviceStatus de cada dispositivo estiver definida como uma string "on". Além disso, verifique se
* a propriedade deviceTurnOnCount foi atualizada corretamente.
Depois de concluir a implementação:

Na classe SmartHome, defina um método decreaseTvVolume(), changeTvChannelToPrevious(),
*                                 printSmartTvInfo(), printSmartLightInfo() e
* decreaseLightBrightness().
Chame os métodos apropriados das classes SmartTvDevice e SmartLightDevice na classe SmartHome.
Na função main(), chame os métodos adicionados para testar.
* */

fun main() {
    val dev = Developer("Luis")
    val bus = Business(dev)
    bus.work()
}