require 'test/unit'
require 'rack/test'
require_relative './main'

class Security < Test::Unit::TestCase
  include Rack::Test::Methods

  def app
    Sinatra::Application
  end

  def test_249_days_requires_reboot
    get '/', days: '249'
    assert_equal 200, last_response.status
    assert_includes last_response.body, '[i] Reboot is required'
  end

  def test_1337_days_requires_reboot
    get '/', days: '1337'
    assert_equal 200, last_response.status
    assert_includes last_response.body, '[i] Reboot is required'
  end

  def test_zero_should_return_httpForbidden
    get '/', days: '0'
    assert_equal 400, last_response.status
  end

  def test_negative_should_return_httpForbidden
    get '/', days: '-1'
    assert_equal 400, last_response.status
  end

end
