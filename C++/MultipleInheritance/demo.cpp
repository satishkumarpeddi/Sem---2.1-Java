#include <iostream>
class A{
    public :
        void show(){
            std::cout  << "Class A ";
        };
};
class B{
    public:
        void show(){
            std::cout << " Class B";
        };
};
class C: public A,public B{

};
int main(){
    C obj;
    obj.A::show();
    obj.B::show();
}