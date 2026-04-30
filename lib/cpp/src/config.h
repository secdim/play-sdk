#ifndef CONFIG_H
#define CONFIG_H

#include <string>

class Config {
public:
    void loadConfig();
    std::string getSetting(const std::string& key);
};

#endif // CONFIG_H
