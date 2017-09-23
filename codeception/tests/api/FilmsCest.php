<?php
use \Codeception\Util\HttpCode;

class FilmsCest
{
    public function _before(ApiTester $I)
    {
      echo "\n*** Setup test ***";
    }

    public function _after(ApiTester $I)
    {
      echo "\n*** Teardown test ***";
    }

    // tests
    public function getListFilms(ApiTester $I)
    {
      $I->wantTo('Get list of Star Wars Film');
      $I->sendGET('films/');
      $I->seeResponseIsJson();
      $I->seeResponseCodeIs(HttpCode::OK); // 200
      $I->seeResponseContains("opening_crawl");

      $resultData = $I->grabDataFromResponseByJsonPath('$.results');
      $I->assertEquals(count($resultData[0]), 7);

      $I->seeResponseContainsJson(["title" => "A New Hope"]);

      // *** validasi skema JSON *** //
      $I->canSeeResponseIsValidOnSchemaFile(codecept_data_dir('films-schema.json'));

    }
}
