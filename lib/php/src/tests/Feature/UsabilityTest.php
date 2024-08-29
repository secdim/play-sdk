<?php

namespace Tests\Feature;

//use Illuminate\Foundation\Testing\RefreshDatabase;
use Tests\TestCase;

class UsabilityTest extends TestCase
{
    /**
     * A basic test to check if the root route returns "Hello SecDim".
     *
     * @return void
     */
    public function testHelloSecDim()
    {
        $response = $this->get('/');

        $response->assertStatus(200);
        $response->assertSeeText('Hello');
    }
}
