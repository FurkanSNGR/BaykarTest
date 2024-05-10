
Feature: Kariyer Baykartech Navbar Kontrol Tests


  Scenario: Navbar Butonları Kontrol Edilir ve Doğru Sayfaya Yönlendirdiği Görülür

    Given Kariyer Baykar TR anasayfasina girilir
    Then Navbar alanindaki butonlarin dogru sayfaya yonlendirdigi kontrol edilir
    And Tarayici Kapatilir
