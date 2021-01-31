@org.hibernate.annotations.GenericGenerator(
        name = "CUSTOM_ID_GENERATOR_ONE",
        strategy = "enhenced-sequence",
        parameters = {
                @org.hibernate.annotations.Parameter( name = "sequence_name", value = "custom_id_gen_one_sequence"),
                @org.hibernate.annotations.Parameter( name = "initial_value", value = "1000")
        }
)
package com.niteesh.entity.hibernate.sequence;

