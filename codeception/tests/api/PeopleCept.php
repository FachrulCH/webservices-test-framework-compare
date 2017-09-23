<?php
use \Codeception\Util\HttpCode;

$I = new ApiTester($scenario);
$I->wantTo('Get profile of Luke Skywalker');
$I->sendGET('people/1/');
$I->seeResponseIsJson();
$I->seeResponseCodeIs(HttpCode::OK); // 200
$I->seeResponseContains("19BBY");
$I->seeResponseContainsJson(["name" => "Luke Skywalker"]);

// *** validasi skema JSON *** //
$I->canSeeResponseIsValidOnSchemaFile(codecept_data_dir('people-schema.json'));
