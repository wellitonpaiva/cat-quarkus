mvn io.quarkus:quarkus-maven-plugin:0.19.1:create -DprojectGroupId=com.thescientist -DprojectArtifactId=cat-quarkus -DclassName="com.thescientist.CatResource"     -Dpath="/kitty"     -Dextensions="smallrye-fault-tolerance, resteasy-jsonb"