
Feature: Kariyer Baykartech Sayfa İçerik Dili Kontrolü


  Scenario: Kariyer Baykartech Sayfa İçerik Dillerinin Belirlenip Doğru İçeriğin Gösterildiği Kontrolü

    Given Kariyer Baykar TR anasayfasina girilir
    Then Sayfa Dili degistirilir ve icerigin dogru oldugu kontrol edilir
    And Tarayici Kapatilir