
Feature: Kariyer Baykartech Açık Pozisyonlar Kontrol Testi


  Scenario: Acik Pozisyonlar Filtreleme Isleminin Basarili Sekilde Gerceklestigi Kontrol Edilir

    Given Acik pozisyonlar sayfasina girilir
    Then Tum pozisyonların verisi cekilir ve ilgili pozisyon aranarak filtreleme islemi yapilir
    And Tarayici Kapatilir