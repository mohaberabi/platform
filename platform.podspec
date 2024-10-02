Pod::Spec.new do |s|
  s.name             = 'platform'
  s.version          = '0.1.0'
  s.summary          = 'A Kotlin Multiplatform library'
  s.homepage         = 'https://github.com/mohaberabi/platform'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'mohaberabi' => 'moohaberabii98@gmail.com' }
  s.source           = { :git => 'https://github.com/mohaberabi/platform.git', :tag => s.version.to_s }
  s.ios.deployment_target = '12.0'
  s.source_files = 'src/iosMain/**/*'
end
