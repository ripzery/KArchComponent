#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_ripzery_karchitecture_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++ By JNI";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring Java_com_ripzery_karchitecture_MainActivity_getApi(
        JNIEnv *env,
        jobject /* this */,
        jstring keyhash) {
    std::string result;
    std::string str1 = "nL30GI2VwLjUTX3guK9kdlLG6K4=";

    const char * c = str1.c_str();
    const char * str2 = env->GetStringUTFChars(keyhash, NULL);

    if(strcmp(str2, c) == 0){
        result = "Correct";
    }else {
        result = "Incorrect";
    }

    return env->NewStringUTF(result.c_str());
}
